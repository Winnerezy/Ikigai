import { useParams } from "react-router-dom"

function Landing(){
const {title} = useParams()
    return(
        <div>{title}</div>
    )
}

export default Landing