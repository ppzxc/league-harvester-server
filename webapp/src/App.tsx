import {useQuery} from '@tanstack/react-query';
import React, {useState} from 'react';
import {Hateoas} from "./model/page";
import axios from "axios";
import {Grid, Paper} from "@mui/material";
import {styled} from '@mui/material/styles';
import BasicModal from "./Modal";

const Item = styled(Paper)(({theme}) => ({
    backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
    ...theme.typography.body2,
    padding: theme.spacing(1),
    textAlign: 'center',
    color: theme.palette.text.secondary,
}));

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
            const res = await axios.get<Hateoas>("http://39.116.31.103:8488/games", {
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

    const onClickDetail = () => {
        return (
            <BasicModal/>
        )
    }

    return (
        <Grid container spacing={2}>
            {data?._embedded.gameDtoList.map(game => {
                return (
                    <Grid item xs={12}>
                        <Item>
                            <>{game.summonerName} {game.gameId} {game.ranked ? "RANKED" : "NOT RANKED"} {game.winning ? "승리" : "패배"}</>
                        </Item>
                    </Grid>
                )
            })}
        </Grid>
    );
}

export default App;
