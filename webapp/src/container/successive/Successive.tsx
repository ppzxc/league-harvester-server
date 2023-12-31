import React, {useState} from "react";
import Box from "@mui/material/Box";
import {useQuery} from "@tanstack/react-query";
import axios from "axios";
import {SuccessiveVictories} from "../../model/successive";
import LeaderBoard from "../../component/LeaderBoard/LeaderBoard";
import moment from "moment/moment";
import WeekSuccessive from "./WeekSuccessive";
import {Grid, Paper} from "@mui/material";
import Typography from "@mui/material/Typography";

const Successive = () => {

    const [baseDate, setBaseDate] = useState(moment(new Date()).format('YYYY-MM-DD'))

    const {isLoading, error, data, isFetching} = useQuery({
        queryKey: [baseDate],
        queryFn: async (): Promise<SuccessiveVictories> => {
            let params = new URLSearchParams()
            params.append("base", baseDate)
            const res = await axios.get<SuccessiveVictories>("/api/v1/successive-victories", {
                method: 'GET',
                headers: {
                    "Accept": "application/json"
                },
                params: params,
                withCredentials: false
            });
            return res.data;
        }
    })

    return (
        <>
            <Grid item xs={12} md={6} lg={6}>
                <Paper sx={{p: 2, display: 'flex', flexDirection: 'column'}}>
                    <WeekSuccessive baseDate={baseDate} setBaseDate={setBaseDate}/>
                    <Box>
                        <LeaderBoard successiveVictories={data}/>
                    </Box>
                </Paper>
            </Grid>
            <Grid item xs={12} md={6} lg={6}>
                <Paper sx={{p: 2, display: 'flex', flexDirection: 'column'}}>
                    <Typography>랭킹 보드에 유저 클릭시 유저 게임 플레이 목록 표시 위치</Typography>
                </Paper>
            </Grid>
        </>
    )
}

export default Successive;