<a id="readme-top"></a>
<div align="center">
  <h1>Task Manager</h1>
  <h2>First Full Stack Project</h2>
  <i>Spring Boot + Hibernate + JWT + AngularJs</i>
</div>

<br>

> [!WARNING]
> **This project is still not finished.**
> Everything is working, I think the project is a solid base but for now it is running only in a local environment and needs some future improvements.

<a id="about-the-project"></a>
## About The Project
TaskManager is a full-stack task management application designed to help users organize their daily activities efficiently. The project combines a Spring Boot backend with an Angular frontend to provide a secure, interactive, and user-friendly experience.

Users can register and log in to their account, and once authenticated, they can create tasks, update their status, and delete them. Tasks are displayed in a Kanban-style board with three statuses: PENDING, IN_PROGRESS, and DONE. The application ensures that each user only sees and manages their own tasks, providing a secure personal workspace.

The backend handles authentication with JWT tokens, manages data persistence with H2 (local) or PostgreSQL (planned), and exposes REST APIs for task operations. The frontend communicates with the backend to provide real-time updates, form validations, and an intuitive task board interface.
<p align="right">(<a href="#readme-top">back to top</a>)</p>

<hr>

> [!NOTE]
> TO-DO LIST:
> - Redirect NOT logged User to Login Page from the Tasks Page
> - Improve Front-end esthetically
> - Add PostgreSQL DB and remove the local Hibernate one.
> - Learn how to properly store Environment Variables (For the PostgreSQL DB) and not inside the IDE anymore.
> - Host the full website (Frontend and Backend on the same host / separate in two different hosts)
