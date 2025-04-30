import { Exercise } from "./Exercise";
import { TrainingTemplate } from "./TrainingTemplate";

export interface Training {
    id?: number;
    name: string;
    exercises: Exercise[];
    trainingTemplates: TrainingTemplate[];
    dateFrom: string; 
    dateTo: string;
    duration: string; 
  }