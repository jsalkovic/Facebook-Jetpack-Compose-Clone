package hr.josip.facebook.domain.shared

interface BaseInteractor<Request, Response> {

    suspend fun execute(request: Request): Response

}