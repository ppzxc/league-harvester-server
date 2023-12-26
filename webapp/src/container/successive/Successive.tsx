import {Container, CssBaseline, Grid, Paper, Toolbar} from "@mui/material";
import React from "react";
import Box from "@mui/material/Box";
import {useQuery} from "@tanstack/react-query";
import axios from "axios";
import {SuccessiveVictories} from "../../model/successive";

const Successive = () => {

    const {isLoading, error, data, isFetching} = useQuery({
        queryKey: ['2023-12-26'],
        queryFn: async (): Promise<SuccessiveVictories> => {
            let params = new URLSearchParams()
            params.append("base", '2023-12-26')
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

    const listing = () => {
        if (data === undefined) {
            return (
                <Grid item xs={12} md={12} lg={12}>
                    <Paper sx={{p: 1, display: 'flex', flexDirection: 'column'}}>
                        <Box sx={{width: '100%', typography: 'body1'}}>
                            <>NO DATA</>
                        </Box>
                    </Paper>
                </Grid>
            )
        } else {
            return (
                data.map(value => {
                    return (
                        <Grid item xs={12} md={12} lg={12}>
                            <Paper sx={{p: 1, display: 'flex', flexDirection: 'column'}}>
                                <Box sx={{width: '100%', typography: 'body1'}}>
                                    <>소환사 이름: {value.summonerName}, 연승 횟수: {value.winningCount},
                                        KDA: {Math.floor(value.totalKill / value.winningCount)}/{Math.floor(value.totalDeath / value.winningCount)}/{Math.floor(value.totalAssist / value.winningCount)}</>
                                </Box>
                            </Paper>
                        </Grid>
                    )
                })
            )
        }
    }

    return (
        <Box sx={{display: 'flex'}}>
            <CssBaseline/>
            <Box
                component="main"
                sx={{
                    backgroundColor: (theme) =>
                        theme.palette.mode === 'light'
                            ? theme.palette.grey[100]
                            : theme.palette.grey[900],
                    flexGrow: 1,
                    height: '100vh',
                    overflow: 'auto',
                }}
            >
                <Toolbar/>
                <Container maxWidth="xl" sx={{mt: 4, mb: 4}}>
                    <Grid container spacing={3}>
                        {listing()}
                    </Grid>
                </Container>
            </Box>
        </Box>
    )
}

export default Successive;