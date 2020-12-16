package pl.bartflor.riverlog.domain.riverlog

import pl.bartflor.riverlog.domain.riverlog.exception.UserNotFoundException
import pl.bartflor.riverlog.domain.riversection.RiverSection
import pl.bartflor.riverlog.domain.riversection.RiverSectionServiceImpl
import pl.bartflor.riverlog.testhelper.RunLogDtoHelper
import spock.lang.Specification
import spock.lang.Subject
import static spock.genesis.Gen.*

class UserServiceUT extends Specification {
	def userRepositoryMock = Mock(UserRepository)
	def riverLogRepositoryMock = Mock(RiverLogRepository)
	def riverSectionServiceMock = Mock(RiverSectionServiceImpl)
	@Subject
	UserServiceImpl userService = new UserServiceImpl(
			userRepositoryMock,
			riverLogRepositoryMock,
			riverSectionServiceMock)

	def "RegisterNewUser should invoke repository method with proper parameters"() {
		given:
			def userName = string(20).first()
			def name = string(20).first()
			def surname = string(20).first()
			def email = string(20).first()
			def expectedUserArg = new User(userName, name, surname, email, new RiverLog())
		when:
			userService.registerNewUser(userName, name, surname, email)
		then:
			1 * userRepositoryMock.createUser(_) >> { argument -> User given = argument.get(0)
											assert given == expectedUserArg}
	}

	def "LogNewRun should add object with proper parameters"() {
		given:
			def userName = string(20).first()
			def name = string(20).first()
			def surname = string(20).first()
			def email = string(20).first()
			def riverLog = new RiverLog()
			def user = new User(userName, name, surname, email, riverLog)
			def section = Mock(RiverSection)
		when:
			userService.logNewRun(userName, RunLogDtoHelper.createRandom())
		then:
			1 * riverSectionServiceMock.getSectionById(_) >> section
			1 * userRepositoryMock.findUser(userName) >> Optional.of(user)
			1 * riverLogRepositoryMock.updateUserLog(_,_) >>
					{ args -> String givenUserName = args.get(0)
						RiverLog log = args.get(1)
						assert givenUserName == userName
						assert log == riverLog }
		and:
			riverLog.getRunLogList().size() == 1
	}

	def "LogNewRun should throw exception given non existing userName"() {
		given:
			def userName = string(20).first()
		when:
			userService.logNewRun(userName, RunLogDtoHelper.createRandom())
		then:
			1 * userRepositoryMock.findUser(userName) >> Optional.empty()
			def ex = thrown(UserNotFoundException)
		and:
			ex.getMessage() == "User with user name: "+userName+", not found"
	}

	def "GetUserRiverLog should return riverLog from user with given userName"() {
		given:
			def userName = string(20).first()
			def name = string(20).first()
			def surname = string(20).first()
			def email = string(20).first()
			def riverLog = new RiverLog()
			def user = new User(userName, name, surname, email, riverLog)
		when:
			def result = userService.getUserRiverLog(userName)
		then:
			1 * userRepositoryMock.findUser(userName) >> Optional.of(user)
		and:
			result == riverLog
	}

	def "GetUserRiverLog should throw exception given non existing userName"() {
		given:
			def userName = string(20).first()
		when:
			userService.getUserRiverLog(userName)
		then:
			1 * userRepositoryMock.findUser(userName) >> Optional.empty()
			def ex = thrown(UserNotFoundException)
		and:
			ex.getMessage() == "User with user name: "+userName+", not found"
	}
}
