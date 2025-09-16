import { User } from "./user.model";
import { TaskStatus } from "./task-status.enum";

export interface Task {
  id: number;
  title: string;
  description: string;
  status: TaskStatus;
  user: User;
  category: any;
}
