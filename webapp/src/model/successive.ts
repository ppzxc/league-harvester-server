import {UUID} from "node:crypto";

export type SuccessiveVictories = SuccessiveVictory[]

export interface SuccessiveVictory {
    id: number,
    playerUuid: UUID,
    profileIconId: number,
    summonerName: string,
    winningCount: number,
    totalKill: number,
    totalDeath: number,
    totalAssist: number,
}