package com.test.grability.domain.usecase
import com.test.grability.domain.repository.MarvelRepository
import com.test.grability.extension.runBlockingTest
import com.test.grability.rule.CoroutineTestRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class GetCharactersUseCaseTest {

    private lateinit var sut: GetAllCharactersUseCase

    @Mock
    lateinit var repository: MarvelRepository

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        sut = GetAllCharactersUseCase(repository)
    }

    @Test
    fun `traer los characters de la BD` () = coroutineTestRule.runBlockingTest {
        //When
        sut()

        //Then
        verify(repository).findAll()
    }
}