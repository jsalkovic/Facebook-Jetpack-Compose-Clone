package hr.josip.composeapp.domain.shared

interface BaseRepository<Request, Response> {

    suspend fun execute(request: Request): Response
}