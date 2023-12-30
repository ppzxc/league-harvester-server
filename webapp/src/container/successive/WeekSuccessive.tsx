import {useQuery} from "@tanstack/react-query";
import axios from "axios";
import {Weeks} from "../../model/week";
import {FormControl, InputLabel, MenuItem, Select, SelectChangeEvent} from "@mui/material";

type Props = {
    baseDate: string,
    setBaseDate: React.Dispatch<React.SetStateAction<string>>
}

const WeekSuccessive = ({baseDate, setBaseDate}: Props) => {

    const {isLoading, error, data, isFetching} = useQuery({
        queryKey: [],
        queryFn: async (): Promise<Weeks> => {
            const res = await axios.get<Weeks>("/api/v1/weeks", {
                method: 'GET',
                headers: {
                    "Accept": "application/json"
                },
                withCredentials: false
            });
            return res.data;
        }
    })

    const handleChange = (event: SelectChangeEvent) => {
        setBaseDate(event.target.value as string);
    };

    return (
        <>
            <FormControl fullWidth>
                <InputLabel id="demo-simple-select-label">주차 선택</InputLabel>
                <Select
                    labelId="demo-simple-select-label"
                    id="demo-simple-select"
                    value={baseDate}
                    label="weekOfMonth"
                    onChange={handleChange}
                >
                    {data?.map(value => <MenuItem
                        value={value.startOfWeek}>{value.month}월 {value.sequenceOfMonth}주차</MenuItem>)}
                </Select>
            </FormControl>
        </>
    )
}

export default WeekSuccessive