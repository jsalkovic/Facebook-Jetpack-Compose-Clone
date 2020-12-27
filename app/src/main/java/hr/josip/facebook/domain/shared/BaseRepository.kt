package hr.josip.facebook.domain.shared

interface BaseRepository<Request, Response> {

    suspend fun execute(request: Request): Response
}