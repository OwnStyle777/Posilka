import { Training } from '@/app/types/Training';
import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api/trainings';


export const getTrainingById = (id: number) => {
    return axios.get<Training>(`${API_BASE_URL}/${id}`);
  };
  
  export const getAllTrainings = () => {
    return axios.get<Training[]>(API_BASE_URL);
  };
  
  export const createTraining = (training: Training) => {
    return axios.post<Training>(API_BASE_URL, training);
  };
  
  export const updateTraining = (id: number, training: Training) => {
    return axios.put<Training>(`${API_BASE_URL}/${id}`, training);
  };
  
  export const deleteTraining = (id: number) => {
    return axios.delete<void>(`${API_BASE_URL}/${id}`);
  };