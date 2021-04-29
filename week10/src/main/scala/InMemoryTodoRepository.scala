import TodoRepository.{TitleAlreadyExists, TodoNotFound}

import java.util.UUID
import scala.concurrent.{ExecutionContext, Future}

class InMemoryTodoRepository(initialTodos:Seq[Todo] = Seq.empty)(implicit ec:ExecutionContext) extends TodoRepository {

  private var todos: Vector[Todo] = initialTodos.toVector

  override def all(): Future[Seq[Todo]] = Future.successful(todos)

  override def done(): Future[Seq[Todo]] = Future.successful(todos.filter(_.done))

  override def pending(): Future[Seq[Todo]] = Future.successful(todos.filterNot(_.done))

  override def create(createTodo: CreateTodo): Future[Todo] = {
    todos.find(_.title == createTodo.title) match {
      case Some(foundTodo) =>
        Future.failed(TitleAlreadyExists(createTodo))
      case None =>
        Future.successful {
          val todo = Todo(
            id = UUID.randomUUID().toString,
            title = createTodo.title,
            description = createTodo.description,
            done = false
          )
          todos = todos :+ todo
          todo
        }
    }
  }

  override def update(id: String, updateTodo: UpdateTodo): Future[Todo] = {
    todos.find(_.id == id) match {
      case None =>
        Future.failed(TodoNotFound(id))
      case Some(foundTodo) =>
        val newTodo = updateHelper(foundTodo, updateTodo)
        todos = todos.map(t => if (t.id == id) newTodo else t)
        Future.successful(newTodo)
    }
  }

  private def updateHelper(todo: Todo, updateTodo: UpdateTodo): Todo = {
    val t1 = updateTodo.title.map(title => todo.copy(title = title)).getOrElse(todo)
    val t2 = updateTodo.description.map(description => t1.copy(description = description)).getOrElse(t1)
    updateTodo.done.map(done => t2.copy(done = done)).getOrElse(t2)
  }

  override def delete(id: String): Future[Vector[Todo]] = {
    todos = todos.filterNot(item => item.id==id)
    Future.successful(todos)
  }

  override def get(id: String): Future[Todo] = {
    val todo = todos.filter(item => item.id==id).head
    Future.successful(todo)
  }
}
