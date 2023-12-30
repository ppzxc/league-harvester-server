import * as React from 'react';
import ListItem from '@mui/material/ListItem';
import Divider from '@mui/material/Divider';
import ListItemText from '@mui/material/ListItemText';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import Avatar from '@mui/material/Avatar';
import Typography from '@mui/material/Typography';
import {SuccessiveVictory} from "../../model/successive";

type Props = {
    successiveVictory: SuccessiveVictory
}

const LeaderBoardItem = ({successiveVictory}: Props) => {
    return (
        <>
            <ListItem alignItems="flex-start">
                <ListItemAvatar>
                    <Avatar alt="Remy Sharp" src="/static/images/avatar/1.jpg"/>
                </ListItemAvatar>
                <ListItemText
                    primary={<React.Fragment>
                        {successiveVictory.summonerName}
                    </React.Fragment>}
                    secondary={
                        <React.Fragment>
                            <Typography
                                variant="body2"
                                color="text.primary"
                            >
                                {successiveVictory.winningCount} 연승
                            </Typography>
                            <Typography
                                variant="body2"
                                color="text.primary"
                            >
                                KDA {Math.floor(successiveVictory.totalKill / successiveVictory.winningCount)}/{Math.floor(successiveVictory.totalDeath / successiveVictory.winningCount)}/{Math.floor(successiveVictory.totalAssist / successiveVictory.winningCount)}
                            </Typography>
                        </React.Fragment>
                    }
                />
            </ListItem>
            <Divider variant="inset" component="li"/>
        </>
    );
}

export default LeaderBoardItem