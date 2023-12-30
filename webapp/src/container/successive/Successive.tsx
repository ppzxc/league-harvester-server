import React, {useState} from "react";
import Box from "@mui/material/Box";
import {useQuery} from "@tanstack/react-query";
import axios from "axios";
import {SuccessiveVictories} from "../../model/successive";
import LeaderBoard from "../../component/LeaderBoard/LeaderBoard";
import moment from "moment/moment";
import WeekSuccessive from "./WeekSuccessive";

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
            <WeekSuccessive baseDate={baseDate} setBaseDate={setBaseDate}/>
            <Box
                display="flex"
                justifyContent="center"
                alignItems="center"
                minHeight="100vh">
                <LeaderBoard successiveVictories={data}/>
            </Box>
        </>
    )
}

export default Successive;