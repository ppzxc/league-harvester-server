export type Weeks = Week[]

export interface Week {
    month: number,
    startOfWeek: string,
    endOfWeek: string,
    sequenceOfMonth: number
}