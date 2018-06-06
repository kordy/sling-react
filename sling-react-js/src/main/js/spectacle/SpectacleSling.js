import React from 'react'
import Deck from './deck'
import Heading from './heading'
import Text from './text'
import Slide from './slide'
import Container from './dialogs/Container'
import SpectacleAuthorRoot from './SpectaceAuthorRoot'
import {BlockQuote, Quote, Cite, Code, CodePane, Link, Image, Appear} from "spectacle";
import EditDialog from './dialogs/EditDialog'
import TreeContainer from './../framework/TreeContainer'
import EditModeToggler from './dialogs/EditModeToggler'
import SlidePropertiesButton from './dialogs/SlidePropertiesButton'
import SystemButtonsContainer from './dialogs/SystemButtonsContainer'
import AddSlideButton from './dialogs/AddSlideButton'
import DeleteSlideButton from './dialogs/DeleteSlideButton'

const components = {
    Code,
    CodePane,
    Deck,
    Heading,
    Text,
    Slide,
    Link,
    BlockQuote,
    Quote,
    Cite,
    Image,
    Appear
};

const Spectacle = ({content}) => (<TreeContainer
        components={components}
        tree={content}/>
);

export default Spectacle