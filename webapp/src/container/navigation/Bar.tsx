import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Menu from '@mui/material/Menu';
import Container from '@mui/material/Container';
import {createTheme, CssBaseline, ThemeProvider, Typography} from "@mui/material";
import Rank from "./Rank";

const Bar = () => {
    const [anchorElNav, setAnchorElNav] = React.useState<null | HTMLElement>(null);

    const handleCloseNavMenu = () => {
        setAnchorElNav(null)
    };

    const FullViewMenu = () => {
        return <>
            <Rank/>
        </>
    }

    const mdTheme = createTheme();

    return (
        <ThemeProvider theme={mdTheme}>
            <Box sx={{display: 'flex'}}>
                <CssBaseline/>
                <AppBar position="absolute">
                    <Container maxWidth="xl">
                        <Toolbar disableGutters>
                            <Typography
                                variant="h6"
                                noWrap
                                component="div"
                                sx={{mr: 2, display: {xs: 'none', md: 'flex'}}}
                            >
                                LOL RANK BOARD
                            </Typography>

                            <Box sx={{flexGrow: 1, display: {xs: 'flex', md: 'none'}}}>
                                <Menu
                                    id="menu-appbar"
                                    anchorEl={anchorElNav}
                                    anchorOrigin={{
                                        vertical: 'bottom',
                                        horizontal: 'left',
                                    }}
                                    keepMounted
                                    transformOrigin={{
                                        vertical: 'top',
                                        horizontal: 'left',
                                    }}
                                    open={Boolean(anchorElNav)}
                                    onClose={handleCloseNavMenu}
                                    sx={{
                                        display: {xs: 'block', md: 'none'},
                                    }}
                                >
                                </Menu>
                            </Box>
                            <Box sx={{flexGrow: 1, display: {xs: 'none', md: 'flex'}}}>
                                {FullViewMenu()}
                            </Box>
                        </Toolbar>
                    </Container>
                </AppBar>
            </Box>
        </ThemeProvider>
    );
};

export default Bar