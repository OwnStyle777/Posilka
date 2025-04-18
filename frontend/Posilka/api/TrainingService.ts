import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api/trainings';


export const getTrainingById = async (id: number): Promise<Training> => {
  const response = await axios.get(`${API_BASE_URL}/${id}`);
  return response.data;
};

export const getAllTrainings = async (): Promise<Training[]> => {
  const response = await axios.get(API_BASE_URL);
  return response.data;
};

export const createTraining = async (training: Training): Promise<Training> => {
  const response = await axios.post(API_BASE_URL, training);
  return response.data;
};

export const updateTraining = async (id: number, training: Training): Promise<Training> => {
  const response = await axios.put(`${API_BASE_URL}/${id}`, training);
  return response.data;
};

export const deleteTraining = async (id: number): Promise<void> => {
  await axios.delete(`${API_BASE_URL}/${id}`);
};