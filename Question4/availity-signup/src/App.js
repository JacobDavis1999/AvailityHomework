import {useState, useEffect} from "react"
import ClientForm from "./components/ClientForm";
import Clients from "./components/Clients";
import Header from "./components/Header";
import { v4 } from "uuid";


function App() {
  //state management for adding new client and toggling form
  const [currentClients, setCurrentClients] = useState([]);
  const [showForm, setShowForm] = useState(false);


  //useEffect to deal with side effects involved with db.json
  useEffect(() => {
    const getClientss = async () =>{
      const clientsFromServer = await fetchClients();
      setCurrentClients(clientsFromServer);
    };

    getClientss();
  }, []);


  //Retrieve client data stored in db
  const fetchClients = async () => {
    const res = await fetch("http://localhost:5000/clients");
    const data = await res.json();
    return data;
  }

  //function to add client info into db
  const addClient = async (firstName, lastName, NPINumber, businessAddress, phoneNumber, email ) => {
    const newClient = {
      firstName,
      lastName,
      NPINumber,
      businessAddress,
      phoneNumber,
      email,
    }

    const res = await fetch("http://localhost:5000/clients", {
      method: "POST",
      headers: {
        "Content-type": "application/json",

      },
      body: JSON.stringify(newClient)
    })

    const data = await res.json();

    setCurrentClients([...currentClients, newClient]);
  }

  //function to delete clients from db
  const deleteClient = async (id) =>{

    await fetch(`http://localhost:5000/clients/${id}`, {
      method: "DELETE",
      

      });


    const newClientList = currentClients.filter((t) =>{
      return t.id !== id;
    })
  setCurrentClients(newClientList);
  }

  //function to toggle client sign up form
  const toggleForm = () =>{
    setShowForm(!showForm);
  }

  //display all components and pass down props
  return (
    <div className="App">
      <Header toggleForm={toggleForm}/>
      <div className="container">
        {showForm ? <ClientForm addClient={addClient} />: null }
      <Clients clientData={currentClients} deleteClient ={deleteClient}/>
      </div>
    </div>
  );
}

export default App;
