import axios from "axios";
import { Exercise } from "../types/Exercise";

const BASE_URL = "http://localhost:8080/api/exercises";

export const getExerciseById = (id: number) => {
  return axios.get<Exercise>(`${BASE_URL}/${id}`);
};

export const getAllExercises = () => {
  return axios.get<Exercise[]>(BASE_URL);
};

export const createExercise = (exercise: Exercise) => {
  return axios.post<Exercise>(BASE_URL, exercise);
};

export const updateExercise = (id: number, exercise: Exercise) => {
  return axios.put<Exercise>(`${BASE_URL}/${id}`, exercise);
};

export const deleteExercise = (id: number) => {
  return axios.delete<void>(`${BASE_URL}/${id}`);
};

export const getExercisesByTrainingId = (trainingId: number) => {
  return axios.get<Exercise[]>(`${BASE_URL}/training/${trainingId}`);
};

export const getExercisesByTemplateId = (templateId: number) => {
  return axios.get<Exercise[]>(`${BASE_URL}/template/${templateId}`);
};