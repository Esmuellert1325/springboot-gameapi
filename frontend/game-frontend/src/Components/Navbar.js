import React from "react";
import ShowGames from './ShowGames';
import AddGame from "./AddGame";
import BottomNavigation from '@mui/material/BottomNavigation';
import BottomNavigationAction from '@mui/material/BottomNavigationAction';

export default function Navbar() {
    const [value, setValue] = React.useState('showGames');

    return (
        <>
            {value === 'showGames' ? 
                <ShowGames />
            :
                <AddGame />
            }

            <BottomNavigation
                className="bottom-nav"
                showLabels
                value={value}
                onChange={(event, newValue) => {
                    setValue(newValue);
                }}
            >
                <BottomNavigationAction label="Show Games" value="showGames" />
                <BottomNavigationAction label="Add Game" value="addGame" />
            </BottomNavigation>
        </>
    )
}