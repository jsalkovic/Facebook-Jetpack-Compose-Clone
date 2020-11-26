package hr.josip.composeapp.domain.shared

interface BaseInteractor<Request, Response> {

    suspend fun execute(request: Request): Response

}