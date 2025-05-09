import { Series } from "./Series";
import { History } from "./History";
export interface Exercise{
    id?: number;
  name: string;
  trainingTemplateId?: number;
  trainingId?: number;
  instructions: string;
  muscleGroup: string;
  difficulty: string;
  muscles: string;
  pr?: string;
  mediaUrl?: string;
}