import {Games} from "./game";

export interface Hateoas {
    _embedded: Games,
    _links: Links,
    page: Page,
}

export interface Links {
    self: Href,
}

export interface Href {
    href: string
}

export interface Page {
    size: number,
    totalElements: number,
    totalPages: number,
    number: number,
}