import {useQuery} from '@tanstack/react-query';
import React, {useState} from 'react';
import {Hateoas} from "./model/page";
import axios from "axios";
import {Container, CssBaseline, Grid, Paper, Toolbar} from "@mui/material";
import Box from "@mui/material/Box";
import {Copyright} from "@mui/icons-material";
import {
    DataGrid,
    GridCallbackDetails,
    GridColDef,
    GridPaginationModel,
    GridToolbarColumnsButton,
    GridToolbarContainer,
    GridToolbarDensitySelector,
    GridToolbarExport
} from "@mui/x-data-grid";

export const gameColumn: GridColDef[] = [
    {field: 'id', headerName: 'ID', width: 75},
    {field: 'playerUuid', headerName: 'PUUID', width: 150},
    {field: 'summonerId', headerName: 'SUMMONER_ID', width: 150},
    {field: 'summonerName', headerName: 'SUMMONER_NAME', width: 150},
    {field: 'gameId', headerName: 'GAME_ID', width: 150},
    {field: 'reportGameId', headerName: 'REPORT_GAME_ID', width: 150},
    {field: 'detectedTeamPosition', headerName: 'DETECTED_TEAM_POSITION', width: 150},
    {field: 'selectedPosition', headerName: 'SELECTED_POSITION', width: 150},
    {field: 'queueType', headerName: 'QUEUE_TYPE', width: 150},
    {field: 'ranked', headerName: 'RANKED', width: 150},
    {field: 'championId', headerName: 'CHAMPION_ID', width: 150},
    {field: 'championName', headerName: 'CHAMPION_NAME', width: 150},
    {field: 'spell1Id', headerName: 'SPELL_1_ID', width: 150},
    {field: 'spell2Id', headerName: 'SPELL_2_ID', width: 150},
    {field: 'leaver', headerName: 'LEAVER', width: 150},
    {field: 'botPlayer', headerName: 'BOT_PLAYER', width: 150},
    {field: 'localPlayer', headerName: 'LOCAL_PLAYER', width: 150},
    {field: 'winning', headerName: 'WINNING', width: 150},
    {field: 'championsKilled', headerName: 'CHAMPIONS_KILLED', width: 150},
    {field: 'assists', headerName: 'ASSISTS', width: 150},
    {field: 'numDeaths', headerName: 'NUM_DEATHS', width: 150},
    {field: 'barracksKilled', headerName: 'BARRACKS_KILLED', width: 150},
    {field: 'gameEndedInEarlySurrender', headerName: 'GAME_ENDED_IN_EARLY_SURRENDER', width: 150},
    {field: 'gameEndedInSurrender', headerName: 'GAME_ENDED_IN_SURRENDER', width: 150},
    {field: 'goldEarned', headerName: 'GOLD_EEARNED', width: 150},
    {field: 'totalDamageDealt', headerName: 'TOTAL_DAMAGE_DEALT', width: 150},
    {field: 'totalDamageDealtToBuildings', headerName: 'TOTAL_DAMAGE_DEALT_TO_BUILDINGS', width: 150},
    {field: 'totalDamageDealtToChampions', headerName: 'TOTAL_DAMAGE_DEALT_TO_CHAMPIONS', width: 150},
    {field: 'totalDamageDealtToObjectives', headerName: 'TOTAL_DAMAGE_DEALT_TO_OBJECTIVES', width: 150},
    {field: 'totalDamageDealtToTurrets', headerName: 'TOTAL_DAMAGE_DEALT_TO_TURRETS', width: 150},
    {field: 'totalDamageTaken', headerName: 'TOTAL_DAMAGE_TAKEN', width: 150},
];

function App() {
    const [page, setPage] = useState<number>(0)
    const [size, setSize] = useState<number>(20)
    const [totalPages, setTotalPages] = useState<number>(0)
    const [totalElements, setTotalElements] = useState<number>(0)

    const {isLoading, error, data, isFetching} = useQuery({
        queryKey: [page, size],
        queryFn: async (): Promise<Hateoas> => {
            let params = new URLSearchParams()
            params.append("page", String(page))
            params.append("size", String(size))
            const res = await axios.get<Hateoas>("/games", {
                method: 'GET',
                headers: {
                    "Accept": "application/json"
                },
                params: params,
                withCredentials: false
            });
            setPage(res.data.page.number)
            setSize(res.data.page.size)
            setTotalPages(res.data.page.totalPages)
            setTotalElements(res.data.page.totalElements)
            return res.data;
        }
    })

    const onChangePagination = (model: GridPaginationModel, details: GridCallbackDetails) => {
        if (details.reason === "setPaginationModel") {
            if (model.pageSize !== 0) {
                setPage(model.page)
                setSize(model.pageSize)
            }
        }
    }

    const customToolBar = () => {
        return (
            <GridToolbarContainer>
                <GridToolbarColumnsButton/>
                <GridToolbarDensitySelector/>
                <GridToolbarExport/>
                {/*<TableFilterPopover gridColumnDef={gridColumnDef} rootFilters={filters} setRootFilters={setFilters}/>*/}
                {/*<TableSortPopover gridColumnDef={gridColumnDef} rootSorts={sorts} setRootSorts={setSorts}/>*/}
            </GridToolbarContainer>
        )
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
                        <Grid item xs={12} md={12} lg={12}>
                            <Paper sx={{p: 1, display: 'flex', flexDirection: 'column'}}>
                                <Box sx={{width: '100%', typography: 'body1'}}>
                                    <div style={{height: 670, width: '100%'}}>
                                        <DataGrid
                                            // key
                                            getRowId={(row) => row.id}
                                            // data
                                            rows={data === undefined ? [] : data._embedded === undefined ? [] : data._embedded.gameDtoList}
                                            columns={gameColumn}
                                            // pagination
                                            paginationMode="server"
                                            paginationModel={{
                                                page: page,
                                                pageSize: size
                                            }}
                                            rowCount={totalElements}
                                            pageSizeOptions={[20, 60, 100]}
                                            onPaginationModelChange={onChangePagination}
                                            // design
                                            slots={{
                                                toolbar: customToolBar,
                                            }}
                                            rowHeight={20}
                                            checkboxSelection
                                            // loading
                                            loading={isLoading}
                                        />
                                    </div>
                                </Box>
                            </Paper>
                        </Grid>
                    </Grid>
                    <Copyright sx={{pt: 4}}/>
                </Container>
            </Box>
        </Box>
        // <Grid container spacing={2}>
        //     {data?._embedded.gameDtoList.map(game => {
        //         return (
        //             <Grid item xs={12}>
        //                 <Item>
        //                     <>{game.summonerName} {game.gameId} {game.ranked ? "RANKED" : "NOT RANKED"} {game.winning ? "승리" : "패배"}</>
        //                 </Item>
        //             </Grid>
        //         )
        //     })}
        // </Grid>
    );
}

export default App;
