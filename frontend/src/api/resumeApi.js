import axios from "axios";

const api = axios.create({
  baseURL: import.meta.env.VITE_API_BASE_URL,
});

export const analyzeText = async (payload) => {
  const response = await api.post("/analysis/analyze-text", payload);
  return response.data;
};

export const analyzeFile = async (file, jobDescription) => {
  const formData = new FormData();
  formData.append("file", file);
  formData.append("jobDescription", jobDescription);

  const response = await api.post("/analysis/analyze-file", formData, {
    headers: {
      "Content-Type": "multipart/form-data",
    },
  });

  return response.data;
};

export const getHistory = async (page = 0, size = 10) => {
  const response = await api.get(`/analysis/history?page=${page}&size=${size}`);
  return response.data;
};

export const searchHistory = async (fileName) => {
  const response = await api.get(
    `/analysis/history/search?fileName=${encodeURIComponent(fileName)}`
  );
  return response.data;
};

export const filterHistory = async (minScore) => {
  const response = await api.get(
    `/analysis/history/filter?minScore=${minScore}`
  );
  return response.data;
};