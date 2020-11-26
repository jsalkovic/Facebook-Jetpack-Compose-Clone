package hr.josip.composeapp.domain.shared

interface BaseUseCase<Request, Response> {

    suspend fun execute(request: Request): Response
}