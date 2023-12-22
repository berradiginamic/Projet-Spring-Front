const [state, setState] = useState([]); //store the fetched data
const [page, setPage] = useState(1); //keep a track of the page numbers
const [genre, setGenre] = useState([]);//used to store the non-selected genre values
const [value, setValue] = useState([]);//used to store the selected genre values

<Genre
  genre={genre}
  setGenre={setGenre}
  setPage={setPage}
  type="film"
  value={value}
  setValue={setValue}
/>