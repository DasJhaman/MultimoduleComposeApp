package de.multimodule.compposeapp.data.repo.features.users


import de.multimodule.compposeapp.data.api.feature_user.UserApi
import de.multimodule.compposeapp.data.api.dto.UserDto
import de.multimodule.compposeapp.data.mapper.toUsers
import de.multimodule.compposeapp.domain_layer.features.userlist.models.Users
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.kotlin.*
import java.io.IOException

class UserRepositoryImpTest {
    private lateinit var userRepository: UserRepositoryImp
    private lateinit var userApi: UserApi

    @Before
    fun setUp() {
        userApi = mock()
        userRepository = UserRepositoryImp(userApi)
    }

    @Test
    fun `getUserList should emit list of users when API call is successful`() = runTest {
        // Mock the API response
        val users = listOf(UserDto(id = 1, userName = "Fake", name = "hell", email = ""))
        val apiResponse = Result.success(users)

        whenever(userApi.getUsers()).thenReturn(apiResponse)

        val userList = userRepository.getUserList().toList()

        verify(userApi).getUsers()

        assertEquals(users.toUsers(), userList.first())
    }


    @Test
    fun `getUserList should emit empty list when API call fails`() = runBlockingTest {
        // Mock the API response
        val apiResponse = Result.failure<List<UserDto>>(IOException())
        whenever(userApi.getUsers()).thenReturn(apiResponse)

        val userList = userRepository.getUserList().toList()

        verify(userApi).getUsers()

        assertEquals(emptyList<Users>(), userList.first())
    }

}