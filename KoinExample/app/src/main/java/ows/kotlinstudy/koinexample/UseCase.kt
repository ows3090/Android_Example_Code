package ows.kotlinstudy.koinexample

class UseCase(private val repo: Repository) {
    fun execute() = repo.getText()
}