package de.multimodule.compposeapp.domain_layer.features.userlist.features.users

import de.multimodule.compposeapp.domain_layer.features.userlist.models.Users
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.kotlin.whenever

class GetUsersListUseCaseTest{

    private lateinit var getUsersListUseCase: GetUsersListUseCase
    private lateinit var userRepository: UserRepository

    @Before
    fun setUp() {
        userRepository = mock()
        getUsersListUseCase = GetUsersListUseCase(userRepository)
    }

    @Test
    fun `invoke should return user list from repository`() = runTest {
        val userList = listOf(Users(name = "Fake", userName = "fakeUserName", email = "fake@gamil.com", id = 1))
        whenever(userRepository.getUserList()).thenReturn(flowOf(userList))

        val result = getUsersListUseCase()
        val resultList = result.toList()
        verify(userRepository).getUserList()

        assertEquals(userList, resultList.first())
    }
}