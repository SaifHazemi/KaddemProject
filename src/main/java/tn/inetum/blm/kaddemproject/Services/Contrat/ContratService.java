package tn.inetum.blm.kaddemproject.Services.Contrat;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.inetum.blm.kaddemproject.Entities.Contrat;
import tn.inetum.blm.kaddemproject.Entities.Etudiant;
import tn.inetum.blm.kaddemproject.Entities.Specialite;
import tn.inetum.blm.kaddemproject.Repository.ContratRepository;
import tn.inetum.blm.kaddemproject.Repository.EtudiantRepository;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ContratService implements IContratService{

    private  final ContratRepository contratRepository;
    private  final EtudiantRepository etudiantRepository;

    @Override
    public List<Contrat> retrieveAllContrats() {
        return (List<Contrat>) contratRepository.findAll();
    }

    @Override
    public Contrat updateContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Contrat addContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return contratRepository.findById(idContrat).orElse(null);
    }

    @Override
    public void removeContrat(Integer idContrat) {
        contratRepository.delete(retrieveContrat(idContrat));

    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {

        Etudiant etudiant = etudiantRepository.findEtudiantByNomEAndPrenomE(nomE,prenomE).orElse(null);
        Assert.notNull(etudiant,"Etudiant not fund");
        Integer nbrContrats  = contratRepository.countContratByArchiveIsFalseAndEtudiant_NomEAndEtudiant_PrenomE(nomE,prenomE);
        Assert.isTrue(nbrContrats >= 5 , "Nombre de contarts est > = 5  ");
//        if (etudiant == null || etudiant.getContrats().size() >= 5) {
//            return null;
//        }
        ce.setEtudiant(etudiant);
        etudiant.getContrats().add(ce);
        etudiantRepository.save(etudiant);
        return ce;
    }

    @Override
    public Map<Specialite, Float> getMontantContratEntreDeuxDate(Integer idUniv, Date startDate, Date endDate) {
        List<Contrat> contrats = contratRepository.findByArchiveIsFalseAndEtudiant_Departement_IdDepartAndDateDebutContratAfterAndAndDateFinContratBeforeOrderBySpecialite( idUniv, startDate, endDate);
        Map<Specialite, Float> montantContratParSpecialite = new HashMap<>();
        for (Contrat contrat : contrats) {
            Specialite specialite = contrat.getSpecialite();
            float montantContrat = contrat.getMontantContrat();
            LocalDate d1 = LocalDate.parse(contrat.getDateFinContrat().toString(), DateTimeFormatter.ISO_LOCAL_DATE);
            LocalDate d2 = LocalDate.parse(contrat.getDateDebutContrat().toString(), DateTimeFormatter.ISO_LOCAL_DATE);
            Duration diff = Duration.between(d2.atStartOfDay(), d1.atStartOfDay());
            long diffDays = diff.toDays();
            float montantcontratsbyhour = montantContrat/diffDays;
            LocalDate enddate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate stratdate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            if (montantContrat == 0) {
                montantContrat = 0;
            }else if (stratdate.isAfter(contrat.getDateDebutContrat())){
                if(contrat.getDateFinContrat().isAfter(enddate)){
                    LocalDate d3 = LocalDate.parse(enddate.toString(), DateTimeFormatter.ISO_LOCAL_DATE);
                    LocalDate d4 = LocalDate.parse(contrat.getDateDebutContrat().toString(), DateTimeFormatter.ISO_LOCAL_DATE);
                    Duration diff1 = Duration.between(d4.atStartOfDay(), d3.atStartOfDay());
                    long diffDays1 = diff1.toDays();
                    montantContrat = montantcontratsbyhour*diffDays1;
                }
            }else{
                if(contrat.getDateFinContrat().isAfter(enddate)){
                    LocalDate d5 = LocalDate.parse(enddate.toString(), DateTimeFormatter.ISO_LOCAL_DATE);
                    LocalDate d6 = LocalDate.parse(stratdate.toString(), DateTimeFormatter.ISO_LOCAL_DATE);
                    Duration diff2 = Duration.between(d6.atStartOfDay(), d5.atStartOfDay());
                    long diffDays2 = diff2.toDays();
                    montantContrat = montantcontratsbyhour*diffDays2;
                }else{
                    LocalDate d7 = LocalDate.parse(contrat.getDateFinContrat().toString(), DateTimeFormatter.ISO_LOCAL_DATE);
                    LocalDate d8 = LocalDate.parse(stratdate.toString(), DateTimeFormatter.ISO_LOCAL_DATE);
                    Duration diff3 = Duration.between(d8.atStartOfDay(), d7.atStartOfDay());
                    long diffDays3 = diff3.toDays();
                    montantContrat = montantcontratsbyhour*diffDays3;
                }
            }
            montantContratParSpecialite.put(specialite, montantContrat);
        }
        return montantContratParSpecialite;
    }



    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        List<Contrat> contrats = contratRepository.findByArchiveIsFalseAndDateDebutContratAfterAndAndDateFinContratBefore(startDate, endDate);
        return contrats.size();
    }
    @Scheduled(cron = "0 0 13 * * ?") // exécution tous les jours à 13h
    @Override
    public String retrieveAndUpdateStatusContrat() {
        contratRepository.findByArchiveIsFalseAndDateFinContrat(LocalDate.now())
                .stream()
                .forEach(contrat -> {
                    contrat.setArchive(true);
                    System.out.println("Le contrat " + contrat.getIdContrat() + " est archivé.");
                });
        contratRepository.findByArchiveIsFalseAndDateFinContratBetween(LocalDate.now() , LocalDate.now().plusDays(15))
                .stream()
                .forEach(contrat -> System.out.println("Le contrat " + contrat.getIdContrat() + " est doit expiré dans 15 jours  Le "+ contrat.getDateFinContrat()));
        return "Les contrats dont la date de fin est aujourd'hui ont été archivés.";
    }
}
