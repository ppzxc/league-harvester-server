import React from "react";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Games from "./container/games/Games";
import Successive from "./container/successive/Successive";

const App = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Successive/>}/>
                <Route path="/successive" element={<Successive/>}/>
                <Route path="/games" element={<Games/>}/>
            </Routes>
        </BrowserRouter>
    );
}

export default App