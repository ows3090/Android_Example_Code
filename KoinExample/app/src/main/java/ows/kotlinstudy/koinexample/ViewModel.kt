package ows.kotlinstudy.koinexample

class ViewModel(private val useCase: UseCase) {
    fun showText() = useCase.execute()
}