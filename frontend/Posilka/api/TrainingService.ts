import { Training } from '@/types/Training';
import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api/trainings';


export const getTrainingById = (id: number): Promise<Training> => {
    return axios.get(`${API_BASE_URL}/${id}`).then(response => response.data);
  };
  
  export const getAllTrainings = (): Promise<Training[]> => {
    return axios.get(API_BASE_URL).then(response => response.data);
  };
  
  export const createTraining = (training: Training): Promise<Training> => {
    return axios.post(API_BASE_URL, training).then(response => response.data);
  };
  
  export const updateTraining = (id: number, training: Training): Promise<Training> => {
    return axios.put(`${API_BASE_URL}/${id}`, training).then(response => response.data);
  };
  
  export const deleteTraining = (id: number): Promise<void> => {
    return axios.delete(`${API_BASE_URL}/${id}`).then(() => {});
  };