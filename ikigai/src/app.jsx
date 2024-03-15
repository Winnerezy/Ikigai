import { BrowserRouter as Router, Route, Routes, useNavigate } from 'react-router-dom';
import { useState, useEffect } from 'react';
import Search from './home/search';
import Landing from './home/landing';

function App(){
    const [title, setTitle] = useState(null)
    const [poster, setPoster] = useState()
    const [about, setAbout] = useState('')
    const [status, setStatus] = useState(null)
    const [score, setScore] = useState('')
    const [genres, setGenres] = useState([''])
    const [episodes, setEpisodes] = useState('')
    //useEffect to run all the data fetching
useEffect (() =>{
    async function fetchData() { 
        if(title){
    const options = {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    }
    const res = await fetch(`https://api.jikan.moe/v4/anime?q=${title}`, options)
    const answer = await res.json()
    setAbout(answer.data[0].synopsis)
    setPoster(answer.data[0].images.jpg.image_url)
    setStatus(answer.data[0].status)
    setScore(answer.data[0].score)
    for(let i = 0; i < answer.data[0].genres.length; i++){
        setGenres(answer.data[0].genres[i].name)
    }
    setEpisodes(answer.data[0].episodes)

}
    }
    fetchData()
}, [title]) //val dependency
    return(
        <Router>
        <Routes>
            <Route path="/" index element={<Search setTitle = {setTitle}/>}/>
            <Route path= "/details/:title" element={<Landing title = {title} poster = {poster} about = {about} status = {status} score = {score} genres = {genres} episodes = {episodes}/>}/>
        </Routes>
        </Router> 
    )
}
export default App