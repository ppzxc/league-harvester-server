import React from "react";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Games from "./container/games/Games";
import Successive from "./container/successive/Successive";
import Layout from "./container/navigation/Layout";
import Bar from "./container/navigation/Bar";

const App = () => {
    return (
        <BrowserRouter>
            <Bar/>
            <Routes>
                <Route element={<Layout/>}>
                    <Route path="/" element={<Successive/>}/>
                    <Route path="/rank/successive-victories" element={<Successive/>}/>
                    <Route path="/admin/games" element={<Games/>}/>
                </Route>
            </Routes>
        </BrowserRouter>
    );
}

export default App