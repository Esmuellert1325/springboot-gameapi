import React from "react";
import CardMedia from '@mui/material/CardMedia';
import Button from '@mui/material/Button';

export default function ShowGames() {
    const URL = 'http://localhost:8080/gameapi/v1'; 
    const [games, setGames] = React.useState([]);

    React.useEffect(() => {
        fetchGames();
    }, []);

    const fetchGames = async () => {
        await fetch(`${URL}/getAll`)
            .then(response => response.json())
            .then(data => setGames(data));
    };

    const deleteGame = e => {
        const ID = parseInt(e.target.id);
        if (games) {
            deleteFromDB(ID);
            setGames(prevElem => prevElem.filter(game => game.id !== ID));
        }
    };

    const deleteFromDB = (id) => {
        fetch(`${URL}/delete/${id}`,
            {method: 'DELETE'}
        );
    };

    return (
        <div>
            <h1>List of Games</h1>
            <div className="game-container">
                {games.map((game) => (
                    <CardMedia
                        key={game.id}
                        sx={{ height: 273, width: 185 }}
                        image={game.coverPath}
                        className="game-conatainer-img"
                    >
                        <Button 
                            id={game.id}
                            className="game-delete-btn" 
                            variant="contained" 
                            color="error"
                            onClick={deleteGame}
                        >
                            DELETE
                        </Button>
                        <h3 className="game-title">{game.name}</h3>
                        <h4 className="game-year">{game.releaseDate}</h4>
                        <h4 className="game-genre">{game.genre}</h4>
                        <h4 className="game-developer">{game.developer}</h4>
                    </CardMedia>
                ))}
            </div>
        </div>
    );
}