// Définition des event handlers
const Previous = () => {
  if (page !== 1) {
    setPage(page - 1);
  } else {
    setPage(page);
  }
};  // Handle bouton précédent

const Next = () => {
  if (page < 10) {
    setPage(page + 1);
  }
};  // Handle bouton suivant

const [page, setPage] = useState(1); // initialized the page state with the initial value of 1

// Partie UI
<div className="my-3 d-flex justify-content-between align-items-center">
  <button className="px-3 py-1 m-1 text-center btn-primary" onClick={Previous}>
    Précédent
  </button>
  <button className="px-3 py-1 m-1 text-center btn-primary" onClick={Next}>
    Suivant
  </button>
</div>;