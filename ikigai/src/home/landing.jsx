import Search from "./search";

function Landing(props){
    let rating = ""
    if(props.score >= 0 && props.score <= 2){
        rating = "Trash";
    }
    else if (props.score >= 2 && props.score <= 4){
        rating = "Bad";
    }
    else if (props.score >= 4 && props.score <= 6){
        rating = "Mid";
    }
    else if (props.score >= 6 && props.score <= 8){
        rating = "Good";
    }
    else if (props.score >= 8 && props.score <= 9){
        rating = "Nice";
    }
    else if (props.score > 9 && props.score < 10){
        rating = "Amazing";
    }
    else if (props.score == 10){
        rating = "Perfect";
    }
    

    return(
        <>
        <div className="grid ml-4 mr-4">
        <section className="flex gap-12 items-center"> 
        <img src= {props.poster} className="rounded-2xl"/>
        <section className="grid grid-cols-1">
        <div className="text-2xl">{props.title}</div>
        <p className="italic">{props.genres}</p>
        </section>
        
        <section className="grid grid-cols-1 gap-2">
        <p className="w-max h-10 bg-white text-1xl text-black rounded-2xl p-2 text-center">{props.status}</p>
        <p className="font-bold text-center">{props.episodes > 1 ? props.episodes + ' episode' : props.episodes + ' episode'}</p>
        </section>
        
        <section>
        <span className="text-1xl Arial "> Score: {(props.score * 10)} / 100</span>
        <p className="text-center">{rating}</p>
        </section>
        
        </section>
        
        <div className="h-80 Arial mt-4">{props.about}</div>
        </div>
        </>
    )
}

export default Landing