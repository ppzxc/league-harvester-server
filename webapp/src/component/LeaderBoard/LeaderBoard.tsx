import {SuccessiveVictories} from "../../model/successive";
import React from "react";
import List from "@mui/material/List";
import LeaderBoardItem from "./LeaderBoardItem";

type Props = {
    successiveVictories: SuccessiveVictories | undefined
}

const LeaderBoard = ({successiveVictories}: Props) => {

    const listing = () => {
        if (successiveVictories === undefined) {
            return (
                <>NO DATA</>
            )
        } else {
            return (
                successiveVictories.map(value => {
                    return (
                        <LeaderBoardItem successiveVictory={value}/>
                    )
                })
            )
        }
    }

    return (
        // <List sx={{width: '100%', maxWidth: 240, bgcolor: 'background.paper'}}>
        <List>
            {listing()}
        </List>
    )
}

export default LeaderBoard