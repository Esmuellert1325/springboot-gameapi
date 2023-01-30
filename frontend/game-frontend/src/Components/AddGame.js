import React from "react";
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';

export default function AddGame() {
    // Cover width: 185px
    // Cover height: 273pxw
    const URL = 'http://localhost:8080/gameapi/v1';
    const [game, setGame] = React.useState({
        name: '',
        releaseDate: '',
        genre: '',
        developer: '',
        coverPath: ''
    });
    const handleAdd = (e) => {
        e.preventDefault();
        fetch(`${URL}/add`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(game)
        })
    }
    const handleChange = (e) => {
        const {value, name} = e.target;
        setGame({...game, [name]:value});
    };

    return (
        <div>
            <h1>Add new Game</h1>
            <div className="add-game-div">
                <TextField id="outlined-basic" label="Game title" variant="outlined" name="name" value={game.name} onChange={handleChange}/>
                <TextField id="outlined-basic" label="Release year" variant="outlined" name="releaseDate" value={game.releaseDate} onChange={handleChange}/>
                <TextField id="outlined-basic" label="Genre" variant="outlined" name="genre" value={game.genre} onChange={handleChange}/>
                <TextField id="outlined-basic" label="Developer" variant="outlined" name="developer" value={game.developer} onChange={handleChange}/>
                <TextField id="outlined-basic" label="Cover Path" variant="outlined" name="coverPath" value={game.coverPath} onChange={handleChange}/>
                <Button variant="contained" onClick={handleAdd}>Submit game</Button>
            </div>
        </div>
    )
}