package hr.josip.facebook.domain.shared

interface BaseUseCase<Request, Response> {

    suspend fun execute(request: Request): Response
}