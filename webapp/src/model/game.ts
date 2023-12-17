import {UUID} from "node:crypto";

export interface Games {
    gameDtoList: Game[]
}

export interface Game {
    id: number,
    playerUuid: UUID,
    summonerId: number,
    summonerName: string,
    gameId: string,
    reportGameId: string,
    detectedTeamPosition: string,
    selectedPosition: string,
    queueType: string,
    ranked: boolean,
    championId: number,
    championName: string,
    spell1Id: string,
    spell2Id: string,
    leaver: boolean,
    botPlayer: boolean,
    localPlayer: boolean,
    winning: boolean,
    championsKilled: number,
    assists: number,
    numDeaths: number,
    barracksKilled: number,
    gameEndedInEarlySurrender: number,
    gameEndedInSurrender: number,
    goldEarned: number,
    totalDamageDealt: number,
    totalDamageDealtToBuildings: number,
    totalDamageDealtToChampions: number,
    totalDamageDealtToObjectives: number,
    totalDamageDealtToTurrets: number,
    totalDamageTaken: number,
}