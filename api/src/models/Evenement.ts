export interface Evenement {
  id: string;
  title: string;
  cover_url: string;
  category: string;
  lead_text: string;
  programs: string;
  description: string;
  date_start: string;
  date_end: string;
  contact_name: string;
  contact_phone: string;
  contact_mail: string;
  address_name: string;
  address_street: string;
  address_zipcode: string;
  address_city: string;
  transport_indications: string;
  cover_alt: string;
  price_type: string;
  price_detail: string;
  access_link: string;
  tags: string;
  fav?: boolean;
}