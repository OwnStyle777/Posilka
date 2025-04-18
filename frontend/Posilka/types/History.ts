import { HistorySeries } from "./HistorySeries";

export interface History{
    id?: number;
    date: string; 
    exerciseId: number;
    series: HistorySeries[];
} 