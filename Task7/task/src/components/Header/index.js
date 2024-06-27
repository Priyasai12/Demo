import { Container} from "react-bootstrap";
import { Link } from 'react-router-dom';
import { FaCartArrowDown } from "react-icons/fa"
import styles from "./Header.module.css"
import { useSelector } from "react-redux";
export default function Header() {
    const { list } = useSelector(state => state.cart)
    return(
        <div className={styles.header}>
            <Container>
                <div className={styles.navbar}>
                     <Link to="/"><h1>NHN</h1></Link>
                    <Link to="/cart" className={styles.cartIcon}>
                        <FaCartArrowDown/>
                        <span>{list?.length}</span>
                    </Link>
                </div>
            </Container>
        </div>
    )
}