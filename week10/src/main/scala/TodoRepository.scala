import scala.concurrent.Future

trait TodoRepository {
  def all(): Future[Seq[Todo]]

  def done(): Future[Seq[Todo]]

  def pending(): Future[Seq[Todo]]

  def create(createTodo: CreateTodo):Future[Todo]

  def update(id: String, updateTodo: UpdateTodo): Future[Todo]

  def delete(id: String): Future[Seq[Todo]]

  def get(id: String): Future[Todo]
}
object  TodoRepository{
  final case class TitleAlreadyExists(createTodo: CreateTodo) extends Exception("")
  final case class TodoNotFound(id: String) extends Exception("")
}