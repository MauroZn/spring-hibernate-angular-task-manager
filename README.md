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
> - If an User is not Logged in and moves into /tasks, he must be redirected to the /login page. (And not to an empty tasks page like now)
> - Properly add PostgreSQL DB and not local one anymore.
> - Check Security and be sure there are no possible ways to do a SQL Injection.
> - Improve Front-end esthetically
> - Host the full website (Must choose if Frontend and Backend on the same host or separate in two different hosts)
> - Learn where and how to store Environment Variables (For the PostgreSQL DB) to use them when the project will be hosted (Right now they are only in my local IDE Env Variables but they are not used)
